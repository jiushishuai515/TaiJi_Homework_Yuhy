#1 redis开机自启动配置

	首先把redis下的目录C:\Redis-x64-3.2.100添加到系统环境变量中
	然后在命令行里可以直接运行redis-service
	之后运行下面命令可以把redis加入到计算机服务中，达到开机启动的目的
	redis-server --service-install
   
#2 mongodb开机自启动配置

	首先把redis下的目录C:\Program Files\MongoDB\Server\4.0\bin添加到系统环境变量中
	然后在命令行里可以直接运行mongo
	 之后运行下面命令可以把mongodb加入到计算机服务中，达到开机启动的目的
	mongo --service-install
	
#3 通过redis实现5分钟内登录失败次数限制（3次失败，不允许登陆）（有多种实现方法）

	1、每次访问通过lpush命令将当前用户id作为键，当前系统时间作为值存入redis
	2、每次访问要进行判断，通过llen命令判断存入数据个数是否大于3，并且通过lindex命令取出倒数第三个数
	据，即访问时间。
	3、比较当前时间与第三次访问时间的差值是否大于一个小时，如果大于则禁止访问，否则允许访问。
	if(jedisCluster.llen("userid")>=3 && System.currentTimeMillis() - 
                Long.parseLong(jedisCluster.lindex("userid",2))<=300*1000){
            //禁止访问
        }else{
            jedisCluster.lpush("userid",System.currentTimeMillis()+"");
            //访问
        }

#4 实现mongodb的map-reduce（不同页数的书籍的汇总）

	实现原理是先query，再map，最后reduce
	因为不需要筛选，不需要query
	map之后为 {"book_name1":[200,200]}
		    {"book_name2":[400,400]}....这种形式
	最后reduce进行迭代，把同一个名字的书对应的页数汇总     
    mongo shell:
    
	db.book.mapReduce( 
    function() { emit(this.book_name,this.pages); }, 
    function(key, values) {return Array.sum(values)}, 
      {  
         query:{null},  
         out:"name_pages" 
      }
	)
	
	java:
	
	String map = "function(){ emit(this.name, this.pages); }";
	String reduce = "function( key, values ){ return Array.sum(values); }";
	MapReduceCommand cmd = new MapReduceCommand(books, map, reduce,
		null, MapReduceCommand.OutputType.INLINE, null);
	MapReduceOutput out = books.mapReduce(cmd);

#5 实现mongo的圆形范围内的地理位置搜索

	distance的单位为'度' 需要进行转换
	{"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
	
	java:
	
	public void findCircleNearTest() {
         List<Location> locations = locationRepository.findCircleNear(new 		Point(x, y),distance);
         locations.forEach(location -> {
            System.out.println(location.toString());
         });
     }
     
#6 ConcurrentHashMap
	
	1、底层采用分段的数组+链表实现，线程安全
	通过把整个Map分为N个Segment，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。(读操作不加锁，由于HashEntry的value变量是 volatile的，也能保证读
	取到	最新的值。)
	2、Hashtable的synchronized是针对整张Hash表的，即每次锁住整张表让线程独占，ConcurrentHashMap允许多个修改操作并发进行，其关键在于使用了锁分离技术
	3、有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁
	4、扩容：段内扩容（段内元素超过该段对应Entry数组长度的75%触发扩容，不会对整个Map进行扩容），插入前检测需不需要扩容，有效避免无效扩容
	与JAVA7的区别
	增加红黑树这个存储结构:
		在Java8中，为什么要增加红黑树这种数据结构来进行存储，而不是全部使用链表来进行存储呢？ 1.因为攻击者可以构造大量具有相同hashCode的内容，使其全部放在同一      	个列表中，这样，在查找的时候，所花费的时间会很长。这个时候，如果采用红黑树这个结构来进行存储，那么其查找的效率会高很多。 2.hashCode()函数的计算有时候并不合理 	，例如重写hashCode函数的时候。如果都映射到同一个位置，那么查找的时间也会很长。
	mappingCount():
		在ConcurrentHashMap中如果存储大量的元素，那么使用size()方法获取的结果可能不正确，因为其是用int类型作为返回值的。
		




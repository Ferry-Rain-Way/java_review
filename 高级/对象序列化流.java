"对象序列化流"
对象序列化:就是将对象保存到磁盘中，或者在网络中传输对象
这种机制就是使用一个字节序列表示一个对象，该字节序列包含:对象的类型、对象的数据和对象中存储的属性等信息
字节序列写到文件之后，相当于文件中持久保存了一个对象的信息
反之，该字节序列还可人从文件中读取回来，重构对象，对它进行反序列化
要实现序列化和反序列化就要使用对象序列化流和对象反序列化流
对象序列化流: ObjectOutputStream
对象反序列化流: ObjectlnputStream


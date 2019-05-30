# readAndWrite

## Serializables objects, json and xml notations - Java
### De objeto a byte[]
ByteArrayOutputStream bs= new ByteArrayOutputStream();
ObjectOutputStream os = new ObjectOutputStream (bs);
os.writeObject(unObjetoSerializable);  
os.close();
byte[] bytes =  bs.toByteArray(); // devuelve byte[]


### De byte[] a objeto
ByteArrayInputStream bs= new ByteArrayInputStream(bytes); // bytes es el byte[]
ObjectInputStream is = new ObjectInputStream(bs);
ClaseSerializable unObjetoSerializable = (ClaseSerializable)is.readObject();
is.close();

# HulkDb
A simple in memory Db that can store key value pairs and can persist them on demand.
A key is of type String and Value is of Type JSONObject.

DataManager  is the main class that manages KeyValueDataStore and FileManager
KeyValueDataStore is the Wrapper Class For the InMemory DataBase.
FileManager Reponsible for managing File Operations and it employs FileRead, FileWrite and FileOptions Classes.

# Usage :
1.Clone the project.
2.Set the default location in DEFAULT_LOCATION_STRING in the FileOptions class under package File.
3.Run the Application class for the Project Demo. It can be used as a playground to test functionalities of Library.

```java

 DataManager dm;
 dm = new DataManager(filename); //just with file name and default location or
 FileOptions options = new FileOptions(filename, filepath);
 dm = new DataManager(options);  //options with filename and default location. Can add new details later if needed.

 dm.set(key, obj); //KEY - STRING , VALUE = JSONObject

 dm.setWithTTL(key, obj, timetoLive); //KEY - STRING , VALUE = JSONObject , TimeToLive in Seconds.

 JSONObject jsonObject = dm.get(KEY); //this is the JSONObject User input.

 dm.delete(key);  //deletes the key value pair if exists.
  dm.exit(); //has to be called before the program gets terminated as it persists to the file.

```

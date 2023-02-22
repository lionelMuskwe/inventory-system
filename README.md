# inventory-system
This is a JavaFx based solution that allows Administrator to manage the inventory of an online E-commerce platform



## Setting up environment

### VM Arguements
Make sure that you add the below code snippet in the VM arguements when attempting to run the application

``` java
--module-path "C:\javafx\javafx-sdk-17.0.6\lib" --add-modules javafx.controls,javafx.fxml
```

Also ensure that you have set up a `User Library` for `Java FX`. When you clone the repo you will need to configure the `build path` such that you add the `Java FX class library`

### Database Connection

We are going to be using a java MysQl Connector API. To set this up download the file `mysql-connector-java-8.0.29-tidb-1.0.2` from theweb. Now:

1. Add the `mysql-connector-java-8.0.29-tidb-1.0.2` inside your package
1. Add the `mysql-connector-java-8.0.29-tidb-1.0.2` through the `Configure build path` as an `External JAR`



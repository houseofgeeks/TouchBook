<?php
$mysqli=new mysqli("server","databasename","password","databasename","port");
$query="DELETE FROM touch_data WHERE uid='".$_GET['uid']."'";
$result=$mysqli->query($query);
$query="INSERT INTO touch_data(uid,name,phone,batch,company,email) VALUES ('".$_GET['uid']."','".$_GET['name']."','".$_GET['phone']."','".$_GET['batch']."','".$_GET['company']."','".$_GET['email']."')";
$result=$mysqli->query($query);
$mysqli->close();
include("get.php");
?>

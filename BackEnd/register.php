<?php
$mysqli=new mysqli("server","databasename","password","databasename","port");
$query="INSERT INTO touch_auth(uid,userid, password) VALUES ('NULL','".$_GET['userid']."','".$_GET['password']."')";
$result=$mysqli->query($query);
$mysqli->close();
include("login.php");
?>

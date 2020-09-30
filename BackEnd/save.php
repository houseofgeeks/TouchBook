<?php
$mysqli=new mysqli("fdb21.awardspace.net","2734291_data","password","2734291_data","3306");
$query="DELETE FROM touch_data WHERE uid='".$_GET['uid']."'";
$result=$mysqli->query($query);
$query="INSERT INTO touch_data(uid,name,phone,batch,company,email) VALUES ('".$_GET['uid']."','".$_GET['name']."','".$_GET['phone']."','".$_GET['batch']."','".$_GET['company']."','".$_GET['email']."')";
$result=$mysqli->query($query);
$mysqli->close();
include("get.php");
?>

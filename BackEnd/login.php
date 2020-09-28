<?php
$mysqli=new mysqli("server","databasename","password","databasename","port");
$data="absent";
$query="SELECT * FROM touch_auth WHERE userid='".$_GET['userid']."' AND password='".$_GET['password']."'";
$result=$mysqli->query($query);
$row = $result->fetch_row();
$data =  $row[0];
$mysqli->close();
echo $data;
?>

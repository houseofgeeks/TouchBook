<?php
$mysqli=new mysqli("server","databasename","password","databasename","port");
$data="";
$query="SELECT * FROM touch_data WHERE uid='".$_GET['uid']."'";
$result=$mysqli->query($query);
$row =$result->fetch_row();
$data = $row[1]." ".$row[2]." ".$row[3]." ".$row[4]." ".$row[5]." ";
echo $data;
?>

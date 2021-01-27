<?php
$mysqli=new mysqli("fdb21.awardspace.net","2734291_data","password","2734291_data","3306");
$data="";
$query="SELECT * FROM touch_auth WHERE userid='".$_GET['userid']."' AND password='".$_GET['password']."'";
$result=$mysqli->query($query);
$row = $result->fetch_row();
$data =  $row[0];
$mysqli->close();
echo $data;
?>

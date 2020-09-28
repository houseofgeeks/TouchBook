<?php
$mysqli=new mysqli("server","databasename","password","databasename","port");
$data="";
$query="SELECT * FROM touch_data";
$result=$mysqli->query($query);
while($row = $result->fetch_assoc())
{
  $data = $data.$row['name']." ".$row['batch']." ".$row['email']." ".$row['phone']." ".$row['company']." "."~"." ";
}
echo $data;
?>

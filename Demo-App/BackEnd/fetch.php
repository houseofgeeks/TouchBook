<?php
$mysqli=new mysqli("fdb21.awardspace.net","2734291_data","password","2734291_data","3306");
$data="";
$query="SELECT * FROM touch_data";
$result=$mysqli->query($query);
while($row = $result->fetch_assoc())
{
  $data = $data.$row['name']." ".$row['batch']." ".$row['email']." ".$row['phone']." ".$row['company']." "."~"." ";
}
echo $data;
?>

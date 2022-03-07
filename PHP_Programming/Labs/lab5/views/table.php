<!--
    Lab 5
    Author: Mahmoud Mohamed Kamal
    Date:   07-03-2022
    File:   table.php
-->
<form method="GET">
    <input type="text" name="search" placeholder="Enter Name or Country" />
    <input type="submit" value="search" />
</form>

<?php

echo "<table border='1'>";
$record_index = 0;
foreach ($all_requrds as $item) {
    if ($record_index === 0) {
        echo "<tr>";
        echo "<td> Name </td>";
        echo "<td> Price </td>";
        echo "<td> Country </td>";
        echo "<td> Pic </td>";
        echo "<td> Details </td>";

        echo "</tr>";
    }
    echo "<tr>";
    $pic = substr($item->Photo, 0, 2) . "tz.png";
    echo "<td>" . $item->product_name . "</td>";
    echo "<td>" . $item->list_price . "</td>";
    echo "<td>" . $item->CouNtry . "</td>";
    echo "<td><img src='images/$pic' /></td>";
    echo "<td><a href='index.php?id=$item->id'>more</a></td>";
    echo "</tr>";

    $record_index++;
}
echo "</table>";
?>
<?php if (!isset($_GET['search'])) { ?>
    <div>
        <a href="<?php echo $previous_link;  ?>">
            << Prev </a> | <a href="<?php echo $next_link;  ?>"> Next >> </a>
    </div>
<?php } ?>
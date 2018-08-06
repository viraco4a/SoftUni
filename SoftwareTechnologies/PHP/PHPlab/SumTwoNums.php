<?php
    if(isset($_GET['num1'])
        && isset($_GET['num2'])) {
        $first = intval($_GET['num1']);
        $second = intval($_GET['num2']);
        $sum = $first + $second;
        echo "$first + $second = $sum";
    }
?>
<form>
    <div>First Number:</div>
    <input type="number" name="num1" />
    <div>Second Number:</div>
    <input type="number" name="num2" />
    <div><input type="submit" /></div>
</form>

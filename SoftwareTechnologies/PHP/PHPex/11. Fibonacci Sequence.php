<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
    <?php
    if (isset($_GET['num'])){
        $number = intval($_GET['num']);
        $array = [1, 1];
        for ($i = 2; $i < $number; $i++){
            $current = fib($array[$i - 2], $array[$i - 1]);
            $array[] = $current;
        }
        echo implode(" ", $array);
    }
    function fib(int $last, int $lastLast){
        return $last + $lastLast;
    }
    ?>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        X: <input type="text" name="num1" />
		Y: <input type="text" name="num2" />
        Z: <input type="text" name="num3" />
		<input type="submit" />
    </form>
    <?php
        if (isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])){
            $first = intval($_GET['num1']);
            $second = intval($_GET['num2']);
            $third = intval($_GET['num3']);
            $counter = 0;
            if($first < 0){
                $counter++;
            }
            if($second < 0){
                $counter++;
            }
            if($third < 0){
                $counter++;
            }
            if($first == 0 || $second == 0 || $third == 0 || $counter % 2 == 0){
                echo "Positive";
            }
            else{
                echo "Negative";
            }
        }
    ?>
</body>
</html>
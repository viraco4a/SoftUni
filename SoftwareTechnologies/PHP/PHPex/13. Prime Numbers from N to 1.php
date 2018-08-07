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
        if(isset($_GET['num'])){
            $number = intval($_GET['num']);

            for ($i = $number; $i >= 2; $i--){
                if(PrimeCheck($i)){
                    echo $i . " ";
                }
            }
        }

        function PrimeCheck(int $number) : bool
        {
            for($i = 2; $i <= sqrt($number); $i++){
                if($number % $i == 0){
                    return false;
                }
            }
            return true;
        }
    ?>
</body>
</html>
<?php
error_reporting(E_ALL);

exec("gpio read 0", $stato);
$led = '<img src="spento.png">';

if (isset($_POST['accendi']))
{
   exec("gpio mode 1 out");
   exec("gpio write 1 1");
   $led = '<img src="acceso.png">';
}
if (isset($_POST['spegni']))
{
   exec("gpio mode 1 out");
   exec("gpio write 1 0");
   $led = '<img src="spento.png"';
}
if (isset($_POST['lettura']))
{
   exec("gpio read 0", $stato);
}
?>

<html>
<head>
<title> EMCelettronica - by Gabriele Guizzardi </title>
</head>

<body>
<H2 align=center> Accensione LED12 tramite pulsante web </H2>

    <form method="post" action="">
    <p align=center>
        LED : <button name="accendi">Accendi</button>
        <button name="spegni">Spegni</button>
	<?php echo $led; ?>
    </p>
    </form>

    <form method="post" action="">
    <p align=center>
        Valore Pulsante : <button name="lettura"> Leggi stato </button>
        <input type="text" name="valor" value= "<?php echo $stato[0]; ?>" >
    </p>
    <p align=center>Tenete premuto il pulsante del circuito e cliccate Leggi Stato.</p>

    </form>

</body>
</html>


<?php
$path = '../lib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
require_once('services/Invoice/InvoiceService.php');
require_once('PPLoggingManager.php');
session_start();

?>
<html>
<head>
	<title>PayPal Invoicing - SendInvoice Sample API Page</title>
	<link rel="stylesheet" type="text/css" href="sdk.css"/>
	<script type="text/javascript" src="sdk.js"></script>
</head>
<body>
<h2>SendInvoice API Test Page</h2>
<?php

//get the current filename
$currentFile = $_SERVER["SCRIPT_NAME"];
$parts = Explode('/', $currentFile);
$currentFile = $parts[count($parts) - 1];
$_SESSION['curFile']=$currentFile;

$logger = new PPLoggingManager('SendInvoice');
if($_SERVER['REQUEST_METHOD'] == 'POST') {
	// create request object
	$requestEnvelope = new RequestEnvelope("en_US");
	$sendInvoiceRequest = new SendInvoiceRequest($requestEnvelope, $_POST['invoiceID']);
	$logger->info("created SendInvoice Object");
	$invoiceService = new InvoiceService();
	// required in third party permissioning
	if(($_POST['accessToken']!= null) && ($_POST['tokenSecret'] != null)) {
		$invoiceService->setAccessToken($_POST['accessToken']);
		$invoiceService->setTokenSecret($_POST['tokenSecret']);
	}
	try {
		$sendInvoiceResponse = $invoiceService->SendInvoice($sendInvoiceRequest);
	} catch (Exception $ex) {
		require_once 'error.php';
		exit;
	}
	$logger->info("Received SendInvoiceResponse:");
	echo "<table>";
	echo "<tr><td>Ack :</td><td><div id='Ack'>". $sendInvoiceResponse->responseEnvelope->ack ."</div> </td></tr>";
	echo "<tr><td>InvoiceID :</td><td><div id='InvoiceID'>". $sendInvoiceResponse->invoiceID ."</div> </td></tr>";
	echo "</table>";
	require 'ShowAllResponse.php';
	echo "<pre>";
	var_dump($sendInvoiceResponse);
	echo "</pre>";
} else {
?>
<form method="POST">
<div id="apidetails">SendInvoice API operation is used to send an invoice to a payer and notify the payer of the pending invoice.</div>
<div class="params">
<div class="param_name">Invoice ID</div>
<div class="param_value"><input type="text" name="invoiceID" value=""
	size="50" maxlength="260" /></div>
</div>
<?php
include('permissions.php');
?>
<input type="submit" name="SendInvoiceBtn" value="Send Invoice" /></form>
<?php
}
?>
<br/><br/><a href="index.php" >Home</a>
</body>
</html>
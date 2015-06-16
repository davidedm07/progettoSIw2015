<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Errore Evasione</title>
</head>
<body>
<f:view>
<h1> <strong>Non è stato possibile evadere l'ordine! 
             Quantità in magazzino non sufficienti per ordine</strong></h1>
             <button onclick="goBack()">Torna al catalogo</button>

<script>
function goBack() {
    window.history.back();
}
</script>
</f:view>
</body>
</html>
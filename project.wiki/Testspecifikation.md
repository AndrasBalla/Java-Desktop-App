# Test Plan

## Introduction

Testplanen beskriver de test som ska utföras på enskilda delar av systemet samt integrations tester på hela systemet. Dessa görs för att kontrollera att systemet uppfyller kraven i kravspecifikationen och följer designspecifikationen. Test Cases beskriver hur ett specifikt test utförs och innehåller testes utfall. Eftersom systemet består av två stora delar: Användargränssnitt och en backend som sköter logiken så behöver vi använda oss av olika typer av testning för att uppnå våra mål. 

## Mål

Målet med dokumentet är att bestämma vilka metoder som kommer att användas för att testa systemet.

## Genomförande av tester backend

1. Steg ett är att skapa Test Cases så att vi täcker alla kraven som finns i kravspecifikationen.
1. Alla fält och metoder ska testas utöver de som är krav.
1. Steg två är att skapa test data så att systemet kan testas automatiskt.
1. Sist så genomförs testerna 

Backend delen testas med hjälp av Junit och automatiseras hed hjälp av Gradle.

## Genomförande av tester UI

När en UI testas så tas hänsyn till lite olika aspekter: Användarvänlighet, Funktionalitet och Tydlighet. Användarvänlighet testas med hjälp av exploration testning där en användare utanför projektet börjar använda systemet och ger feedback på hur lätt det var för den personen att utföra olika arbetsmoment. 

Funktionalitet kommer att testas både explorativt och med hjälp av unit tester. Användaren testar funktionalitet genom att använda systemet och utföra arbetsmoment som ger feedback på skärmen. 

I denna sammanhang så står tydlighet för hur enkelt är det för en ny användare att genomföra ett arbetsmoment utan någon tidigare erfarenhet. Detta testar främst namn givning och positionering av olika element i UIn.

## Test strategi 

1. Unit tests 
1. Stress test
1. Användartester

## Test Schema

1. Planering: Planerings momenten består av Test Plan dokumentet
1. Design: Skrivande av Test Cases
1. Implementering: Så som man implementerar krav så ska Unit tests skrivas för att testa de.
1. Dokumentation: Test Rapport dokument skapas som beskriver utförda test.
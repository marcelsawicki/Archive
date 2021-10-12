$XMLfile = 'D:\Repozytorium\Practice\PowerShell\XML\CharakterystykaUpraw.XML'
[XML]$prod = Get-Content $XMLfile
$b = $prod.CharakterystykaUpraw.ChildNodes | Format-Table -Property Nazwa, Producent
     
foreach($p in $prod.CharakterystykaUpraw.ChildNodes)
{
Write-Host -ForegroundColor Green $p.Nazwa
Write-Host -ForegroundColor Yellow $p.Opis
$p.Producenci.ChildNodes | Format-Table

$enumeratorProducenci = $p.Producenci.ChildNodes.GetEnumerator()
while($enumeratorProducenci.moveNext())
{
    $currentProducent = $enumeratorProducenci.Current
    Write-Host -ForegroundColor DarkCyan $currentProducent.Kraj $currentProducent.Udzial
}

}



//se configura en segundos o minutos la cuenta regresiva para redireccionar
//al login
var limit = "0:10";
if(document.images)
{
    var parseLimit = limit.split(":");
    parseLimit = parseLimit[0] * 60 + parseLimit[1] * 1;
}
function begintimer()
{
    if(!document.images)
        return;
    if(parseLimit === 1)
        window.location = "/CensoWeb/";
    else
    {
        parseLimit -= 1;
        curmin = Math.floor(parseLimit / 60);
        cursec = parseLimit % 60;
        if(curmin === 0)
        {
            curtime = cursec + " Segundos";
            document.getElementById("tiempo").innerHTML = curtime;
        }
        window.status = curtime;
        setTimeout("begintimer()", 1000);
    }                
}            
        


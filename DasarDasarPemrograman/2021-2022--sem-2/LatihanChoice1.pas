PROGRAM LatihanChoice1;

USES CRT;

var bilangan : integer;

BEGIN
        clrscr;

        write('Masukkan bilangan: '); readln(bilangan);

        (*
        if (bilangan mod 2 = 0) then
           begin
             write('bilangan ', bilangan, ' adalah BILANGAN GENAP.');
           end
        else
           begin
             writeln('bilangan ', bilangan, ' adalah BILANGAN GANJIL.');
           end;
        *)

        if (bilangan = 0) then
           begin
             write('Bilangan adalah NOL');
           end
        else if (bilangan > 0) then
           begin
             write('Bilangan adalah POSITIF');
           end
        else
           begin
             write('Bilangan adalah NEGATIF');
           end;


        readkey;
END.
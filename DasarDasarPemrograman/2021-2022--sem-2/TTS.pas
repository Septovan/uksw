PROGRAM SoalTTS_Bank;
USES crt, SysUtils;

var
  selectedMenu, riwayatTransaksiIndex : integer;
  saldo, totalSetor, totalTarikTunai, totalTransfer : longint;
  riwayatTransaksi : array[0..100] of string;

PROCEDURE cekSaldo;
BEGIN
  clrscr;
  writeln('[CEK SALDO]');
  writeln('Saldo Anda saat ini sebesar Rp ', saldo:6);

  readkey;
END;

PROCEDURE setor;
var nominalSetor : longint;
BEGIN
    clrscr;
    writeln('[SETOR]');
    write('Masukkan jumlah setoran: ');readln(nominalSetor);

    IF (nominalSetor mod 50000 <> 0) THEN
        BEGIN
            writeln('Nominal yang ingin ditabung harus kelipatan Rp 50000');
        END
    ELSE
        BEGIN
            totalSetor := totalSetor + nominalSetor;
            saldo := saldo + nominalSetor;
            riwayatTransaksi[riwayatTransaksiIndex] := 'Setor               Rp ' + nominalSetor.ToString;
            writeln('=====================');
            writeln('Anda berhasil menambahkan Rp ', nominalSetor:6);
            writeln('Saldo Anda sekarang Rp ', saldo:6);
            riwayatTransaksiIndex := riwayatTransaksiIndex + 1;
        END;

    readkey;
END;

PROCEDURE tarikTunai;
var nominalTarikTunai : longint;
BEGIN
    clrscr;
    writeln('[TARIK TUNAI]');
    write('Masukan nominal yang ingin ditarik: ');readln(nominalTarikTunai);

    IF nominalTarikTunai mod 50000 <> 0 THEN
        BEGIN
            writeln('Nominal yang ingin ditarik harus kelipatan Rp 50000');
        END
    ELSE IF saldo-nominalTarikTunai < 50000 THEN
        BEGIN
            writeln('Mohon maaf saldo Anda tidak mencukupi! Saldo yang harus disisakan adalah Rp 50000');
        END
    ELSE
        BEGIN
            totalTarikTunai := totalTarikTunai + nominalTarikTunai;
            saldo := saldo - nominalTarikTunai;
            riwayatTransaksi[riwayatTransaksiIndex] := 'Tarik tunai         Rp ' + nominalTarikTunai.ToString;
            writeln('=====================');
            writeln('Saldo Anda sudah dikurangi sebesar Rp ', nominalTarikTunai:6);
            writeln('Saldo Anda sekarang sebesar Rp ', saldo:6);
            riwayatTransaksiIndex := riwayatTransaksiIndex + 1;
        END;

  readkey;
END;

PROCEDURE transfer;
var noRekeningTujuan : string;
    nominalTransfer : longint;
BEGIN
    clrscr;
    writeln('[TRANSFER]');
    write('Masukkan 9 digit no rekening tujuan: ');readln(noRekeningTujuan);

    IF length(noRekeningTujuan) <> 9 THEN
        BEGIN
            writeln('Mohon maaf, no rekening tujuan wajib 9 digit');
        END
    ELSE
        BEGIN
            write('Masukkan nominal yang ingin ditransfer: ');readln(nominalTransfer);
            IF saldo-nominalTransfer < 50000 THEN
                BEGIN
                    writeln('Mohon maaf saldo Anda tidak mencukupi! Saldo yang harus disisakan adalah Rp 50000');
                END
            ELSE
                BEGIN
                    totalTransfer := totalTransfer + nominalTransfer;
                    saldo := saldo - nominalTransfer;
                    riwayatTransaksi[riwayatTransaksiIndex] := 'Transfer            Rp ' + nominalTransfer.ToString;
                    writeln('=====================');
                    writeln('Transfer ke ', noRekeningTujuan, ' berhasil sebesar Rp ', nominalTransfer:6);
                    writeln('Saldo Anda sekarang sebesar Rp ', saldo:6);
                    riwayatTransaksiIndex := riwayatTransaksiIndex + 1;
                END;
        END;

    readkey;
END;

PROCEDURE history;
var i : integer;
BEGIN
    clrscr;
    writeln('[RIWAYAT]');

    FOR i:=0 TO length(riwayatTransaksi) DO
        BEGIN
            IF length(riwayatTransaksi[i]) <= 0 THEN
                BEGIN
                    BREAK;
                END
            ELSE
                BEGIN
                    writeln(riwayatTransaksi[i]);
                END;
        END;

    writeln('=====================');
    writeln('TOTAL SETOR: Rp ', totalSetor:6);
    writeln('TOTAL TARIK TUNAI: Rp ', totalTarikTunai:6);
    writeln('TOTAL TRANSFER: Rp ', totalTransfer:6);
    writeln('=====================');
    writeln('SALDO AKHIR: Rp ', saldo:6);

    readkey;
END;


(*PROGRAM UTAMA*)
BEGIN
  saldo := 500000;
  totalSetor := 0;
  totalTarikTunai := 0;
  totalTransfer := 0;
  riwayatTransaksiIndex := 0;

  clrscr;

  REPEAT
    clrscr;

    writeln('Selamat datang di BANK DDP!');
    writeln('Silahkan pilih menu');
    writeln('1. Cek saldo');
    writeln('2. Setor');
    writeln('3. Tarik tunai');
    writeln('4. Transfer');
    writeln('5. Keluar');

    write('Masukkan menu pilihan Anda: ');readln(selectedMenu);
    CASE (selectedMenu) OF
      1: cekSaldo();
      2: setor();
      3: tarikTunai();
      4: transfer();
      5: history();
      ELSE
        writeln('Menu yang Anda masukkan salah!');readkey;
    END;
  UNTIL selectedMenu = 5;
END.

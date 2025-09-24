class NodeCDLL {
    Object data;
    NodeCDLL sebelum;
    NodeCDLL setelah;
}
public class CircularDoubleLinkedList {
    private NodeCDLL pAwal, pAkhir;
    private int jumlah;

    public CircularDoubleLinkedList() {
        pAwal = null;
        pAkhir = null;
        jumlah = -1;
    }

    public void sisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum= pBaru;
        pBaru.setelah= pBaru;
        if (pAwal == null){
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
            jumlah++;
        }
    }

    public void sisipDataDiAkhir(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum= pBaru;
        pBaru.setelah= pBaru;
        if (pAkhir == null){
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAkhir = pBaru;
            jumlah++;
        }
    }

    public void hapusData(Object dtHapus) {
        NodeCDLL pKini = pAwal;

        if (pAwal.data.equals(dtHapus)){
            if (pAwal == pAkhir) {
                pAwal = null;
                pAkhir = null;
            } else {
                pAwal = pAwal.setelah;
                pAwal.sebelum = pAkhir;
                pAkhir.setelah = pAwal;
            }
            jumlah--;
            return;
        }

        if (pAkhir.data.equals(dtHapus)){
            pAkhir = pAkhir.sebelum;
            pAkhir.setelah = pAwal;
            pAwal.sebelum = pAkhir;
            jumlah--;
            return;
        }

        while (!pKini.data.equals(dtHapus)){
            pKini = pKini.setelah;
        }
        pKini.sebelum.setelah = pKini.setelah;
        pKini.setelah.sebelum = pKini.sebelum;
        jumlah--;
    }

    public void cetak(String Komentar){
        System.out.println(Komentar);
        NodeCDLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while(i < jumlah){
            System.out.print(pCetak.data + "->" );
            pCetak = pCetak.setelah;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.sisipDataDiAwal(new Integer(50));
        cdll.sisipDataDiAwal(new Integer(60));
        cdll.sisipDataDiAwal(new Integer(70));
        cdll.sisipDataDiAwal(new Integer(8));
        cdll.sisipDataDiAwal(new Integer(9));
        cdll.sisipDataDiAwal(new Integer(90));
        cdll.sisipDataDiAwal(new Integer(19));
        cdll.cetak("cdll Asal");
        cdll.sisipDataDiAkhir(new Integer(100));
        cdll.cetak("cdll Tambah Akhir");
        cdll.hapusData(19);
        cdll.cetak("Setelah dihapus");
    }
}

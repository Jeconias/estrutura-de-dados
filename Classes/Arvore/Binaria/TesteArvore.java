public class TesteArvore {

    public static void main(String [] args)
    {

        ArvoreBinaria av = new ArvoreBinaria();
        av.insert(20);
        av.insert(15);
        av.insert(1000);
        av.insert(11);
        av.insert(16);
        av.insert(32);
        av.insert(2000);
        av.insert(12);
        av.insert(25);

        //av.swapElements(av.search(1000), av.search(15));
        av.replace(av.search(20), 5);
        //av.remove(av.search(50));
        //av.remove(av.search(16));

        //av.insert(51);
        av.drawTree();
    }
}
import java.util.List;
import java.util.ArrayList;

public class ArvoreBinaria {

    private No root             = null;
    private int size            = 0;
    private List<No> listNos    = null;            

    public ArvoreBinaria(){}
    public ArvoreBinaria(int elemento)
    {

        this.root = new No();
        this.root.setElemento(elemento);

        this.size = 1;
    }

    // METODOS GENERICOS

    private int size()
    {
        return this.size;
    }

    private int height(No n)
    {
        if(n == null || this.isExterno(n) ) return 0;
        
        int i, h = 0;
        List<No> lista = this.children(n);

        for(i = 0; i < lista.size(); i++)
        {
            h = Math.max(h, this.height( lista.get(i) ));
        }
        return 1+h;
    }

    private boolean isEmpty()
    {
        return (this.root == null) ? true : false;
    }

    // METODOS DE ACESSO

    private No root()
    {
        return this.root;
    }

    private No parent(No n)
    {
        return n.getPai();
    }

    private List<No> children(No n)
    {
        List<No> filhos = new ArrayList<No>();
        filhos.add(n.getFilhoEsquerdo());
        filhos.add(n.getFilhoDireito());
        return filhos;
    }

    private boolean hasLeftChild(No n)
    {
        return (n.getFilhoEsquerdo() != null) ? true : false;
    }

    private boolean hasRightChild(No n)
    {
        return (n.getFilhoDireito() != null) ? true : false;
    }

    // METODOS DE CONSULTA

    private boolean isInternal(No n)
    {
        if(n == null) return false;
        return (n.getFilhoDireito() != null || n.getFilhoEsquerdo() != null) ? true : false;
    }

    private boolean isExterno(No n)
    {
        return (!this.hasRightChild(n) && !this.hasLeftChild(n)) ? true : false;
    }

    private boolean isRoot(No n)
    {
        return (n.getElemento() == this.root.getElemento()) ? true : false;
    }

    private int depth(No n)
    {
        if(n == null) return -1;
        if(this.isRoot(n)) return 0;
        
        return 1 + this.depth(n.getPai());
    }

    private List<No> preOrder(No n, boolean createNoTemp)
    {
        if(createNoTemp == true){ this.listNos = new ArrayList<No>(); }

        if(n == null) return null;

        this.listNos.add(n);

        if(this.hasLeftChild(n))
        {
            this.preOrder(n.getFilhoEsquerdo(), false);
        }

        if(this.hasRightChild(n))
        {
            this.preOrder(n.getFilhoDireito(), false);
        }

        if(createNoTemp == true){ 
            List<No> listTmp = this.listNos;
            this.listNos = null;
            return listTmp;
        }
        return null;
    }

    private List<No> inOrder(No n, boolean createNoTemp)
    {
        if(createNoTemp == true){ this.listNos = new ArrayList<No>(); }

        if(n == null) return null;

        if(this.hasLeftChild(n))
        {
            this.inOrder(n.getFilhoEsquerdo(), false);
        }

        this.listNos.add(n);

        if(this.hasRightChild(n))
        {
            this.inOrder(n.getFilhoDireito(), false);
        }

        if(createNoTemp == true){
            List<No> listTmp = this.listNos;
            this.listNos = null;
            return listTmp;
        }
        return null;
    }

    private List<No> posOrder(No n, boolean createNoTemp)
    {
        if(createNoTemp == true){ this.listNos = new ArrayList<No>(); }

        if(n == null) return null;

        if(this.hasLeftChild(n))
        {
            this.posOrder(n.getFilhoEsquerdo(), false);
        }

        if(this.hasRightChild(n))
        {
            this.posOrder(n.getFilhoDireito(), false);
        }

        this.listNos.add(n);

        if(createNoTemp == true){
            List<No> listTmp = this.listNos;
            this.listNos = null;
            return listTmp;
        }
        return null;
    }

    private List<No> nos(int typeNavigation)
    {
        return (typeNavigation < 0) ? this.preOrder(this.root, true) : 
        ( (typeNavigation == 0) ? this.inOrder(this.root, true) : this.posOrder(this.root, true) );
    }


    private List<Integer> elements(int typeNavigation)
    {
        List<Integer> elements = new ArrayList<Integer>();
        List<No> nosTemp = this.nos(typeNavigation);
        int nosSize = nosTemp.size();

        for(int i = 0; i < nosSize; i++)
        {
            elements.add(nosTemp.get(i).getElemento());
        }
        return elements;
    }


    // METODOS DE ATUALIZACAO

    public int replace(No n, int i) {
        No noTmp = n;


        while(this.isInternal(noTmp))
        {
            noTmp = (this.hasRightChild(noTmp) && i > noTmp.getElemento()) ? noTmp.getFilhoDireito() : noTmp.getFilhoEsquerdo();
        }
       
        if(noTmp == null)
        {
            this.insert(i);
            this.remove(n);
            return i;
        }

        n.setElemento(noTmp.getElemento());
        noTmp.setElemento(i);
		return n.getElemento();
    }
    
    public void swapElements(No n1, No n2) {
		int intTmp = n1.getElemento();
		n1.setElemento(n2.getElemento());
		n2.setElemento(intTmp);
	}


    public boolean insert(int v)
    {
        if(this.isEmpty())
        {
            this.root = new No();
            this.root.setElemento(v);
            return true;
        }

        No aux = this.root;
        No novoNo = new No();
        novoNo.setElemento(v);

        while(true)
        {
            if(v == aux.getElemento())
            {
                return false;
            }else if(v < aux.getElemento()){
                if(aux.getFilhoEsquerdo() != null)
                {
                    aux = aux.getFilhoEsquerdo();
                }else{
                    aux.setFilhoEsquerdo(novoNo);
                    break;
                }
            }else {
                if(aux.getFilhoDireito() != null)
                {
                    aux = aux.getFilhoDireito();
                }else{
                    aux.setFilhoDireito(novoNo);
                    break;
                }
            }
        }

        novoNo.setPai(aux);
        this.size++;
        return true;
    }

    public No remove(No n)
    {
        // MODO DE REMOVER QUANDO NÃO TIVER FILHOS
        if(this.isExterno(n))
        {
            if(this.isRoot(n))
            {
                this.root = null;
            }else{
                if(n.getPai().getFilhoDireito() == n)
                {
                    n.getPai().setFilhoDireito(null);
                }else{
                    n.getPai().setFilhoEsquerdo(null);
                }
                n.setPai(null);
            }
        }else if(this.hasLeftChild(n) && this.hasRightChild(n))
        {
            // REMOVER QUANDO TIVER DOIS FILHOS
            No noTmp = n.getFilhoDireito();
            while(this.hasLeftChild(noTmp))
            {
                noTmp = noTmp.getFilhoEsquerdo();
            }
            this.swapElements(noTmp, n);
            this.remove(noTmp);
        }else{ // REMOVER QUANDO POSSUI APENAS UM FILHO
            if(this.isRoot(n))
            {
                No noTemp = (this.hasLeftChild(n)) ? n.getFilhoEsquerdo() : n.getFilhoDireito();
                noTemp.setPai(null);
                this.root = noTemp;
            }else{
                if(this.hasRightChild(n))
                {
                    n.setElemento(n.getFilhoDireito().getElemento());
                    n.setFilhoEsquerdo(null);
                }else{
                    n.setElemento(n.getFilhoEsquerdo().getElemento());
                    n.setFilhoEsquerdo(null);
                }
            }
            
        }
        return n;
    }

    public No search(int i)
    {
        No noTemp = this.root;

        while(noTemp != null)
        {
            if(i == noTemp.getElemento())
            {
                return noTemp;
            }else if(i > noTemp.getElemento())
            {
                noTemp = noTemp.getFilhoDireito();
            }else{
                noTemp = noTemp.getFilhoEsquerdo();
            }
        }
        return noTemp;
    }

    public void drawTree()
    {
        int [][] table;
        int i, j, nosSize, rows;
        List<No> nos = this.nos(0);

        rows = (this.height(this.root) + 1);
        nosSize = nos.size();
        table = new int[rows][nosSize];

        for(i = 0; i < nosSize; i++)
        {
            table[ this.depth(nos.get(i)) ][i] = nos.get(i).getElemento();
            //System.out.println( this.depth(nos.get(i)) + " | " + nos.get(i).getElemento());
        }

        for(i = 0; i < rows; i++)
        {
            for(j = 0; j < nosSize; j++)
            {
                if(table[i][j] != 0)
                {
                    System.out.print(table[i][j] + "   "); 
                }else{
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }        
    }
}
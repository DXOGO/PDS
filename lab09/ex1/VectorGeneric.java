import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
    
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;
    
    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }
    
    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }
    
    private void ensureSpace() {
        if (nElem>=dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem );
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem-i-1 > 0) // not last element
                System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }
    
    public T getElem(int i) {
        return (T) vec[i];
    }

    // return iterator
    public Iterator<T> Iterator(){
        return (this).new VectorIterator<T>();
        
    }

    // return list iterator (index is 0)
    public ListIterator<T> listIterator(){
        return (this).new VectorListIterator<T>(0);

    }

    // return list iterator (index is not 0)
    public ListIterator<T> listIterator(int index){ // start at index
        return (this).new VectorListIterator<T>(index);
    
    }

    
    private class VectorIterator<T> implements Iterator<T> {

        private int index;

        VectorIterator(){ index = 0; }

        @Override // check if there is more elements
        public boolean hasNext() { return (index < nElem); }
    
        @Override // returns the next value in the Vector OR error message out of bounds
        public T next() {
            if (hasNext()){
                @SuppressWarnings("unchecked")
                T r = (T) VectorGeneric.this.vec[index++];
                return r;
            }
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        public void remove(){   // optional remove function
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }
    
    }

    private class VectorListIterator<T> implements ListIterator<T>{

        private int index;

        VectorListIterator(int index){ index = this.index; }

        @Override
        public boolean hasNext() { 
            
            if (this.index < nElem){ return true; } 
            else { this.index--; return false; }        
        }

        @Override
        public boolean hasPrevious() {
            if (this.index > 0){ return true; }
            else { this.index++; return false; }
        }

        public T next() {
            if (hasNext())
                return (T) VectorGeneric.this.vec[this.index++];
            throw new NoSuchElementException("Index out of bounds!");
        }

        
        public T previous() {
            if (hasPrevious()) {
                return (T) VectorGeneric.this.vec[this.index--];
            }
            throw new NoSuchElementException("Index out of bounds!");
        }


        @Override
        public int nextIndex() { return this.index+1; }

        @Override
        public int previousIndex() { return this.index-1; }

        @Override // optional, so ignored
        public void add(T e) {
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }

        @Override // optional, so ignored
        public void remove() {
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }

        @Override // optional, so ignored
        public void set(T e) {
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }
        
    }

    
    

}
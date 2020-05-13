package java.expressions;

import java.Cell;
import java.Sheet;
import java.Expression;
import java.util.Set;

public final class expSS implements Expression{

    private final Cell ref1;
    private final Cell ref2;

    public expSS(String ref1, String ref2, String op){
        this.ref1 = Sheet.getCell(ref1);
        this.ref2= Sheet.getCell(ref2);
        this.op = op;
        updateReferences();
    }

    private void updateReferences(){
        references.clear();
        references.add(ref1);
        references.add(ref2);
        references.addAll(ref1.getFormula().getReferences());
        references.addAll(ref2.getFormula().getReferences());
    }

    @Override
    public Set<Cell> getReferences() {
        // TODO Auto-generated method stub
        return references;
    }
}
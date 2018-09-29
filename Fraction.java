package project3;

/**
 * The fraction class defines a constructor for a Fraction object which has two attributes: a numerator and a denominator and those are the values that are used
 * to compare the fraction passed to the compareTo method to the root fraction of the node during the insertion process in SearchTree. Cross multiplication is the fundamental way
 * of comparing fractions and that is the means by which the fractions are evaluated. If the value returned is greater than 1, it is assigned to the right, and if it is less than
 * 1, it is assigned to the left, denoting the passed fraction is greater than or less than the root fraction. Equivalence is allowed and a new node will simply be created 
 * with respect to where in the tree the recursive method is currently at. The toString() method here reintroduces the backslash character between the numerator and denominator 
 * when the program is asked to return a Fraction object in String form.
 */
class Fraction implements Comparable <Fraction> {

    private Integer numerator;
    private Integer denominator;

    
    Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int compareTo(Fraction incomingFracNode) {
        
        int topToBottomMultiply = numerator * incomingFracNode.denominator;
        int bottomToTopMultiply = incomingFracNode.numerator * denominator;
        return topToBottomMultiply - bottomToTopMultiply;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
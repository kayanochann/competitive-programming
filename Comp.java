import java.util.Objects;

public class Comp {
    static class Complex implements Comparable<Complex>, Cloneable {
        int x, y;

        Complex(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Complex mul(Complex c) {
            int X = this.x * c.x - this.y * c.y;
            int Y = this.x * c.y + this.y * c.x;
            Complex res = new Complex(X, Y);
            return res;
        }

        Complex sub(Complex c) {
            int X = this.x - c.x;
            int Y = this.y - c.y;
            Complex res = new Complex(X, Y);
            return res;
        }

        Complex plus(Complex c) {
            int X = this.x + c.x;
            int Y = this.y + c.y;
            Complex res = new Complex(X, Y);
            return res;
        }

        public int compareTo(Complex c1) {
            if (this.x == c1.x) {
                return Integer.compare(this.y, c1.y);
            }
            return Integer.compare(this.x, c1.x);
        }

        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        public boolean equals(Object obj) {
            Complex c = (Complex) obj;
            return this.compareTo(c) == 0 ? true : false;
        }

        int norm(Complex c) {
            return (this.x - c.x) * (this.x - c.x) + (this.y - c.y) * (this.y - c.y);
        }

        public Complex clone() {
            Complex res = new Complex(this.x, this.y);
            return res;
        }
    }
}

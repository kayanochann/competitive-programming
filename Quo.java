import java.util.Objects;

import ac_library.MathLib;

public class Quo {
    static class Quotient implements Comparable<Quotient>, Cloneable {
        long a, b;

        Quotient(long a, long b) {
            if (a != 0 && b != 0) {
                long g = MathLib.gcd(a, b);
                this.a = a / g;
                this.b = b / g;
                if (this.a < 0) {
                    this.a = -this.a;
                    this.b = -this.b;
                }
            } else if (a != 0) {
                this.a = 1;
                this.b = 0;
            } else if (b != 0) {
                this.a = 0;
                this.b = 1;
            } else {
                this.a = 0;
                this.b = 0;
            }
        }

        public int compareTo(Quotient q) {
            if (this.a == q.a) {
                return Long.compare(this.b, q.b);
            }
            return Long.compare(this.a, q.a);
        }

        public boolean equals(Object o) {
            Quotient q = (Quotient) o;
            if (this.a == q.a && this.b == q.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.a, this.b);
        }

        public Quotient clone() {
            Quotient res = new Quotient(this.a, this.b);
            return res;
        }

    }
}
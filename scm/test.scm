(load "builtin.scm")
(load "init.scm")

(newline)
(newline)

(assert (= (b+ 1 1) 2))
(assert (= (+ 1 2 3) 6))
(assert (= (- 5 2 1) 2))
(assert (= (- 8 1 -1 1) 7))


(assert (= (* 2 2 3) 12))

(< 1 2 3)
(> 3 2 1)
(>= 3 3 2 2 1 1)
(<= 1 1 2 2 3 3)

(assert (= (max 1 2 3 4 3 2 1) 4))
(zero? 1)
(zero? 0)
(positive? -1)
(positive? 1)
(if (not #f) "true")
(if (not (> 1 2)) "true")
(list 1 2 3)
(length '(1 2 3 4 5 (6 7)))
(append '(1 2) 4)
(reverse '(1 2 3))
(and #t #t 1)

(odd 2)
(odd 4)
(odd -4)
(newline)
(odd 1)
(odd 3)
(odd -3)

(newline)
(newline)

(even 4)
(even -4)
(even -2)
(even -2)

(newline)

(even 3)
(even 1)
(even -3)
(even -1)
(define (double x) (+ x x))
(map double '(1 2 3))
(for-each display '(1 2 3))
(for-each (lambda (x) (newline) (display x))
                (list 57 321 88))
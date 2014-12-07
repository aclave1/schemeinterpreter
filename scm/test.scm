(load "builtin.scm")
(load "ini.scm")
(define (assert pred) (if pred (display "")(display "failed\n")))
(newline)
(newline)
(newline)
(newline)
(assert (= (+ 1 2 3) 6))
(assert (= 1 1))
(assert (= 2 2))
(assert (= -1 -1))
(assert (= (- 5 2 1) 2))
(assert (= (- 8 1 -1 1) 7))
(assert (= 42))
(assert (= (* 2 2 3) 12))
(assert (eq? (< 1 2 3) #t))
(assert (eq? (<= 1 1 2 2 3 3) #t))
(assert (eq? (>= 3 3 2 2 1 1) #t))
(assert (eq? (> 3 2 1) #t))
(assert (eq? (< 1 2 3) #t))
(assert (eq? (= 1 1 1 1) #t))
(assert (eq? (= 1 1 1 2) #f))

(assert (= (max 1 2 3 4 3 2 1) 4))
(assert (= (min 1 2 3 4 5 6 5 4) 1))


(assert (eq? (zero? 1) #f))
(assert (eq? (zero? 0) #t))
(assert (eq? (zero? 0) #t))
(assert (eq? (positive? -1) #f))
(assert (eq? (positive? 1) #t))
(assert (eq? (negative? 1) #f))
(assert (eq? (negative? -1) #t))
(assert (eq? (not #f) #t))
(assert(eq? (and #t #t #t 1) 1))

(assert (= (and #t #t 1) 1))
(assert (eq? (and #t #f "if you see this you failed") #f))

(assert (eq? (or #f #f 1) 1))
(assert (equal? (list 1 2 3) '(1 2 3)))
(assert (= (length '(1 2 3)) 3))
(assert (= (length(list 1 2 3)) 3))
(assert (= (length '(1 2 3 4 5 (6 7))) 6))
(assert (equal? (append '(1 2) 4) '(1 2 . 4)))
(assert (equal? (reverse '(1 2 3)) '(3 2 1)))
"move this string around to mark what test failed in your code"
(assert (eq? (odd? 2) #f) )
(assert (eq? (odd? 4) #f) )
(assert (eq? (odd? -4) #f) )
(assert (eq? (odd? 1) #t) )
(assert (eq? (odd? -3) #t) )
(assert (eq? (odd? 3) #t) )
(assert (eq? (even?  4) #t))
(assert (eq? (even? -4) #t))
(assert (eq? (even? -2) #t))
(assert (eq? (even? -2) #t))
(newline)

(assert (eq? (even? 3) #f))
(assert (eq? (even? 1) #f))
(assert (eq? (even? -3) #f))
(assert (eq? (even? -1) #f))
(define (double x) (+ x x))
(assert (equal? (map double '(1 2 3)) '(2 4 6)))
(assert (equal? (map + '(1 1) '(2 2) '(3 3)) '(6 6)))
(for-each display '( good job ))
(newline)
(assert (equal? (memq 'a '( f p a q  b c)) '(a q b c) ))
(assert (equal? (memv 'a '( f p a q  b c)) '(a q b c) ))
(assert (equal? (member 'a '( f p a q  b c)) '(a q b c) ))
(define e '((a 1) (b 2) (c 3)))
(assert (equal? (assq 'a e) '(a 1)))
(assert (equal? (assv 'a e) '(a 1)))
(assert (equal? (assoc 'a e) '(a 1)))
(assert (equal? (map + '(1 1) '(2 2)) '(3 3)))
(assert (equal? (map * '(1 1) '(2 2)) '(2 2)))

(assert (eq? (equal? '(1 2) '(1 2)) #t))
(assert (eq? (equal? "alex" "alex") #t))

(assert (eq? (eq? 1 1)#t))
(assert (eq? (eq? 1 2)#f))


(define (ddisplay x y)
    (begin (display x)(display" ")(display y)(display" ")))
(for-each ddisplay '(good your for-each ) '( job n-ary works))

(assert (= (max 1) 1))

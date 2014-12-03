(define (odd x) (cond ((= x 0) #t) ((= x 1) #f) (else (odd (abs(- 2 x))))))
(define (even x) (not (odd x)))
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
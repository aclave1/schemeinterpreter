(define (+ . l) (if (null? l) 0 (b+ (car l) (apply + (cdr l)))))
(define (- . l) (if (null? l) 0 (b- (car l) (apply - (cdr l)))))
(define (* . l) (if (null? l) 1 (b* (car l) (apply * (cdr l)))))

(define (= x y . l) (if (b= x y) (if (not (null? (cdr l)))) (= y (car l) (cdr l)) (= y (car l))))

(define (< x y . l) (if (b< x y) (if (not (null? (cdr l)))) (< y (car l) (cdr l)) (< y (car l))))
(define (> x y . l) (if (b> x y) (if (not (null? (cdr l)))) (> y (car l) (cdr l)) (> y (car l))))
(define (<= x y . l) (if (b<= x y) (if (not (null? (cdr l)))) (<= y (car l) (cdr l)) (<= y (car l))))
(define (>= x y . l) (if (b>= x y) (if (not (null? (cdr l)))) (>= y (car l) (cdr l)) (>= y (car l))))


(define (max x y . l) (if (bmax x y) (if (not (null? (cdr l)))) (max y (car l) (cdr l)) (max y (car l))))
(define (min x y . l) (if (bmin x y) (if (not (null? (cdr l)))) (min y (car l) (cdr l)) (min y (car l))))


(define (zero? x) (if (= x 0) #t #f))
(define (positive? x) (> x 0))
(define (negative? x) (< x 0))
(define (not pred) (if pred #f #t))

(define (list . x) (cons (car x) (cdr x)))
(define (length l) (if (null? l) 0 (+ 1 (length (cdr l)))))
(define (append l x)(if (null? l) x (cons (car l) (append (cdr l) x))))
(define (last . l) (if(= (length l) 1) (car l) (apply last (cdr l))))
(define (reverse l)
    (let (acc '())
        (append acc (car l))
        (reverse (cdr l) acc)))

(define (and . l)
    (if (eq? #t (car l))
        (apply and (cdr l))
        #f))

(define (or . l) (if (eq? (car l) #f) (apply or (cdr l)) (car l)))

(define (odd x) (cond ((= x 0) #t) ((= x 1) #f) (else (odd (abs(- 2 x))))))
(define (even x) (not (odd x)))

(define (map f l)
    (if (null? l) l
        (cons (f (car l)) (map f (cdr l)))))

(define (for-each f l)
    (if (not (null? l))
        (begin
            (f (car l))
            (for-each f (cdr l)))))


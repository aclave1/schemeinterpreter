(define (+ . l) (if (null? l) 0 (b+ (car l) (apply + (cdr l)))))

(define (- . l)
    (let
        ((x (car l))
         (list (cdr l))
         (minus (lambda (y)
                    (if (null? y) 0
                        (begin
                            (b- x y)
                            (minus (cdr y)))))))))

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
(define (append l x) (if (null? l) x (cons (car l) (append (cdr l) x))))
(define (last . l) (if (= (length l) 1) (car l) (apply last (cdr l))))
(define (reverse l)
    (let (acc '())
        (append acc (car l))
        (reverse (cdr l) acc)))

(define (and . l)
    (if (eq? #t (car l))
        (apply and (cdr l))
        #f))

(define (or . l) (if (eq? (car l) #f) (apply or (cdr l)) (car l)))

(define (odd? x) (cond ((= x 0) #t) ((= x 1) #f) (else (odd? (abs (- 2 x))))))
(define (even? x) (not (odd? x)))


(define (unary-map f l)
    (if (null? l) l
        (cons (f (car l)) (unary-map f (cdr l)))))

(define (unary-foreach f l)
    (if (not (null? l))
        (begin
            (f (car l))
            (unary-foreach f (cdr l)))))

;;n-ary map
(define (map f . l)
    (let ((extract (ll)(cons (caar ll) (extract (cdr ll)))))
        (apply unary-map (extract l))
        (map f (cdr l))))



(define (memv? x l)
    (if (null? l) #f
        (if (eq? x (car l))
            #t
            (memv? x (cdr l)))))

(define (intersection l s)
    (cond
        ((null? l) '())
        ((memv? (car l) s) (cons (car l) (intersection (cdr l) s)))
        (else (intersection (cdr l) s))))

;;
;; iterates over the list and returns l if pred function is true when called with x and l as args
(define (retlist pred x l)
    (cond
        ((null? l) #f)
        ((pred x (car l)) l)
        (else (memq x (cdr l)))))

(define (memq x l)
    (retlist eq? x l))
(define (memv x l)
    (retlist eqv? x l))
(define (member x l)
    (retlist equal? x l))

;;same deal except operates on an assoc list
(define (assochelper pred key list)
    (cond
        ((null? list) '())
        ((pred key (caar list)) (car list))
        (else (assochelper pred key (cdr list)))))

(define (assq x l)(assochelper eq? x l))
(define (assv x l)(assochelper eqv? x l))
(define (assoc x l)(assochelper equal? x l))
;;





(define (caar l) (car (car l)))
(define (caaar l) (car (car (car l))))
(define (caaaar l) (car (car (car (car l)))))
(define (cadr l) (car (cdr l)))
(define (caddr l) (car (cdr (cdr l))))
(define (cadddr l) (car (cdr (cdr (cdr l)))))
(define (cdar l) (cdr (car l)))
(define (cddar l) (cdr (cdr (car l))))
(define (cdddar l) (cdr (cdr (cdr (car l)))))
(define (cddddr l) (cdr (cdr (cdr (cdr l)))))
(define (cdddr l) (cdr (cdr (cdr l))))
(define (cddr l) (cdr (cdr l)))
(define (cadar l) (car (cdr (car l))))
(define (caadar l) (car (car (cdr (car l)))))
(define (cadaar l) (car (cdr (car (car l)))))
(define (cdadarr l) (cdr (car (cdr (car l)))))


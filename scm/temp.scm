(define (land . l)
    (if (eq? #t (car l))
        (apply land (cdr l))
        #f))


(land #t #t #t)

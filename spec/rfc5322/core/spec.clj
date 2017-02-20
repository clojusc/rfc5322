(ns rfc5322.core.spec
  (:require [rfc5322.core :refer :all]
            [speclj.core :refer :all]))

(describe "The email address validator"
  (it "returns false when given an empty email address"
    (should-not (valid? "")))
  (it "returns false when given an email address without an ampersat"
    (should-not (valid? "test")))
  (it "returns false when given an email address without a local part or domain"
    (should-not (valid? "@")))
  (it "returns false when given an email address without a domain"
    (should-not (valid? "test@")))
  (it "returns true when given an email address with a local part and country code top-level domain"
    (should (valid? "test@io")))
  (it "returns false when given an email address without a local part"
    (should-not (valid? "@io")))
  (it "returns false when given an email address without a local part but with a domain name and generic top-level domain"
    (should-not (valid? "@iana.org")))
  (it "returns true when given an email address with a local part and a domain name with a generic top-level domain"
    (should (valid? "test@iana.org")))
  (it "returns true when given an email address with a country code top-level domain"
    (should (valid? "test@nominet.org.uk")))
  (it "returns true when given an email address with a sponsored top-level domain"
    (should (valid? "test@about.museum")))
  (it "returns true when given a one character local part"
    (should (valid? "a@iana.org")))
  (it "returns true when given a one character domain name"
    (should (valid? "test@e.com")))
  (it "returns true when given a one character top-level domain"
    (should (valid? "test@iana.a")))
  (it "returns true when given a local part with a dot (.)"
    (should (valid? "test.test@iana.org")))
  (it "returns false when given a local part that begins with a dot (.)"
    (should-not (valid? ".test@iana.org")))
  (it "returns false when given a local part that ends with a dot (.)"
    (should-not (valid? "test.@iana.org")))
  (it "returns false when given a local part with consecutive dots (.)"
    (should-not (valid? "test..iana.org")))
  (it "returns false when given an email address with no domain"
    (should-not (valid? "test_exa-mple.com")))
  (it "returns true when given a local part of valid symbols"
    (should (valid? "!#$%&`*+/=?^'{|}~@iana.org")))
  (it "returns false when given an escaped ampersat in the local part"
    (should-not (valid? "test\\@test@iana.org")))
  (it "returns true when given a local part of only digits"
    (should (valid? "123@iana.org")))
  (it "returns true when given a domain name of only digits"
    (should (valid? "test@123.com")))
  (it "returns true when given a top-level domain of only digits"
    (should (valid? "test@iana.123")))
  (it "returns true when given a domain that is an IPv4 address"
    (should (valid? "test@255.255.255.255")))
  (it "returns true when given a local part of 64 characters"
    (should (valid? "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl@iana.org")))
  (it "returns false when given a local part of 65 characters"
    (should-not (valid? "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklm@iana.org"))))

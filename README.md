# rfc5322

[![Build Status][travis-badge]][travis]
[![Dependencies Status][deps-badge]][deps]
[![Clojars Project][clojars-badge]][clojars]
[![Tag][tag-badge]][tag]
[![JDK version][jdk-v]](.travis.yml)
[![Clojure version][clojure-v]](project.clj)

[![][logo]][logo-large]

*A Parser for the Internet Message Format (RFC 5322)*


## Usage

There's a nice little prompt when you start up a REPL:

```bash
$ lein repl
```

```clj
nREPL server started on port 46050 on host 127.0.0.1 - nrepl://127.0.0.1:46050
REPL-y 0.3.7, nREPL 0.2.12
Clojure 1.8.0
OpenJDK 64-Bit Server VM 1.8.0_121-8u121-b13-0ubuntu1.16.04.2-b13

To demo the code, try the following:

    (demo-lite)
    (source demo-lite)
    (source lite)

    (demo-full)
    (source demo-full)
    (source full)
    (source ->map)

rfc5322.dev=>
```

Try those out, then look at the source code in the following
locations:

* `dev-resources/src/rfc5322/dev.clj`
* `src/rfc5322/core.clj`

The test message used in `dev.clj` is here:

* `test/rfc5322/core/test.clj`


## License

Copyright © 2013, Zachary Kuhn

Copyright © 2017, Clojure-Aided Enrichment Center

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


<!-- Named page links below: /-->

[travis]: https://travis-ci.org/clojusc/rfc5322
[travis-badge]: https://travis-ci.org/clojusc/rfc5322.png?branch=master
[deps]: http://jarkeeper.com/clojusc/rfc5322
[deps-badge]: http://jarkeeper.com/clojusc/rfc5322/status.svg
[logo]: resources/images/logo.png
[logo-large]: resources/images/logo-large.png
[tag-badge]: https://img.shields.io/github/tag/clojusc/rfc5322.svg
[tag]: https://github.com/clojusc/rfc5322/tags
[clojure-v]: https://img.shields.io/badge/clojure-1.8.0-blue.svg
[jdk-v]: https://img.shields.io/badge/jdk-1.7+-blue.svg
[clojars]: https://clojars.org/clojusc/rfc5322
[clojars-badge]: https://img.shields.io/clojars/v/clojusc/rfc5322.svg

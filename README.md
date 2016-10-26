# Tiny: An Experiment in Dejavafication

A doubly-linked node base-class for endogenous lists.
Lists are circular with a single sentinel node serving as the list header.
Your class needs to subclass TinyNode to play.

It's a linked list, but it's nothing like your *average* Java list class.
In fact, it's loosely based on (but certainly not identical to) the infamous
[exec lists](http://wiki.amigaos.net/wiki/Exec_Lists_and_Queues)
I fondly remember growing up with.

## Notes

- insertAfter(x) = insert(x, x.next())
- insertBefore(x) = insert(x.prev(), x)

## Todo

- Benchmark some comparison to a "regular" list.

## Notes

- At first it may seem like the header/sentinel should be avoidable.
  The problem without it, however, is how to terminate a loop over
  the list properly.
  With a header we can start with `current = list.next()` and use a
  condition like `while (current != list)` to stop when we're back at
  the beginning.
  Without a header (meaning the first node has data already) we'd have
  to start with `current = list` instead, so the previous condition
  doesn't work anymore; but neither does `while (current != list.prev())`
  because then we'd stop too early (before processing the last node).
  Hence using a header/sentinel seems like a good tradeoff.

## License

The MIT License.
See `LICENSE.md` for details.

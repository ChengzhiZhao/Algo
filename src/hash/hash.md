Why review hash tables?
As Dan Blumenthal, Director of Engineering at TripAdvisor noted in his excellent article How to Prepare for Technical Interviews:

"A special note on Hash Tables [...] Interviewers love these. Know how they work – intimately – and know the difference between Maps and Sets. You can frequently get from O(n2) or O(n*ln(n)) down to O(n) by using a Hash Table or Set, and understanding the tradeoffs (e.g., more memory vs. more time) can start an interesting conversation that will impress your interviewer."

And Steve Yegge:

"Hashtables are arguably the single most important data structure known to mankind. You absolutely have to know how they work. Again, it's like one chapter in one data structures book, so just go read about them."

What you need to know
After my college CS courses, I thought I understood hash tables well enough to get by in my interviews. Heck, I used them all the time! But it took a bit more work to feel I had a grasp of the tradeoffs and functionality. I was asked about their details in half of my interviews.

Here are some steps you should take toward gaining a deep understanding of hash tables:

Read the explanations of hash tables on this StackOverflow post. No one explanation will give you a full understanding, but if you work through all of the 1+ point answers you'll have most of the nuances down. If you have time, work through this post about implementing table lookup in C++. If you're having trouble understanding these posts, start with this simple SparkNotes explanation of hash tables and collisions.
To understand the nuances and recent advances in hash table optimization, read through the Wikipedia article on hash tables. Learn a bit about what makes for a good hash key as well.
Don't confuse your terms. This sentence should make sense: to build an unsorted associative array, a hash table can be used—a hash function is used to place items at memory locations in an implementation array.
Complete this week's interview question
There's a lot of angles to continue learning about hash tables from. Try to gain an understanding of at least three different strategies for resolving collisions and for generating hash keys.

As an exercise, reply to me with your best explanation of hash tables and any other resources you found helpful in understanding them. I'll post the best ones next week for those who still haven't fully grasped it yet.

Problem of the week
We're having so much fun this week with hash tables already, why stop!

For this week, take a stab at implementing a hash table in your favorite programming language. That is to say, write a data structure that will let you map keys to values and give you amortized constant-time access. Your implementation should have some form of collision handling--what do you do when your hash function maps two keys to the same place?

This is a game of taboo—don't use any associative arrays (dictionaries, hash.*s, {}s, PHP array(k=>v)s etc) in your implementation. Time yourself, and time box your attempt to one hour. As Yegge notes: "You should be able to implement one using only arrays in your favorite language, in about the space of one interview."
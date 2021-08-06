package CiserCipher

object CiserCipher {
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"


val E=(c:Char,key:Int,a:String)=> a((a.indexOf(c.toUpper)+key)%a.size)


  val D: (Char, Int, String) => Char = (c: Char, key: Int, a: String) => a((a.indexOf(c.toUpper) - key) % a.length)

  val cipher: ((Char, Int, String) => Char, String, Int, String) => String = (algo: (Char, Int, String) =>
    Char, s: String, key: Int, a: String) =>
    s.map(algo(_, key, a))



  def main(args: Array[String]): Unit = {
println("Select Choice:")
    println("1:Encrpt")
    println("2.Decrpyt")

    val choice = scala.io.StdIn.readInt()
    if(choice==1)
      {
        println("Enter the key value:")
        val b = scala.io.StdIn.readInt()
        println("Enter the string to Encrypt")
        val s=scala.io.StdIn.readLine()
        val ct: String = cipher(E, s, b, alphabet)
        println(" String after encrypted: " + ct)
        val pt: String = cipher(D, ct, b, alphabet)
        println(" String again after decrypted: "+ pt)
      }

    else if(choice==2){
      println("Enter the key value:")
      val d = scala.io.StdIn.readInt()
      println("Enter the string to Decrypt")
      val dec=scala.io.StdIn.readLine()
      val pt: String = cipher(D, dec, d, alphabet)
      println(" String again after decrypted: "+ pt)
    }

    else{
      println("Invalid Choice")
    }



  }
}

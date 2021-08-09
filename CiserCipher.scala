package FunctionScala

object CaesarCipher {
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"


  val E=(c:Char,key:Int,a:String)=> a((a.indexOf(c.toUpper)+key)%a.size)


  val D=(c:Char,key:Int,a:String)=> a(if((a.indexOf(c.toUpper)-key)%a.size >=0) (a.indexOf(c.toUpper)-key)%a.size else a.size+(a.indexOf(c.toUpper)-key)%a.size)

  val cipher: ((Char, Int, String) => Char, String, Int, String) => String = (algo: (Char, Int, String) =>
    Char, s: String, key: Int, a: String) =>
    s.map(algo(_, key, a))



  def main(args: Array[String]): Unit = {

    println("Press 1 to encrypt ")
    println("Press 2 to decrpyt ")

    val num = scala.io.StdIn.readInt()
    if(num==1)
    {
      println("Enter the string to Encrypt")
      val str=scala.io.StdIn.readLine()
      println("Enter the key value:")
      val key = scala.io.StdIn.readInt()
      val ct: String = cipher(E, str, key, alphabet)

      println(" String after encrypted: " + ct)
      val pt: String = cipher(D, ct, key, alphabet)
      println(" String again after decrypted: "+ pt)
    }

    else if(num==2){
      println("Enter the key value:")
      val key = scala.io.StdIn.readInt()
      println("Enter the string to Decrypt")
      val str=scala.io.StdIn.readLine()

      val pt: String = cipher(D, str, key, alphabet)


      println(" String again after decrypted: "+ pt)
    }

    else{
      println("Invalid Option")
    }



  }

}

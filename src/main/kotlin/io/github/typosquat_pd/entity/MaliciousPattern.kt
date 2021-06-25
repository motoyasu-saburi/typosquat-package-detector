package io.github.typosquat_pd.entity

class MaliciousPattern {

    // TODO Enum? & replace IP to wildcard
    // reference: PentestMonkey https://pentestmonkey.net/cheat-sheet/shells/reverse-shell-cheat-sheet
    val reverseShell = listOf<String>(
        // Bash
        "bash -i",
        "/dev/tcp/",
        "/bin/sh",
        "/bin/bash",
        "nc -e",
        // Python
        "import socket",
        "subprocess.call",
        "__import__('pty')",
        // Ruby
        "TCPSocket.open",
        // PHP
        "fsockopen",
        "TCPSocket.open",
        "getRuntime()",
        ".exec(",
    )

    val lateralMove = listOf<String>(
    )

    val backdoor = listOf(
        "/etc/crontab",
        "/etc/cron*",
        "/etc/at*",
        "/etc/anacrontab",
        "/var/spool/cron/crontabs/roo"
    )

    // TODO add pattern
    //   https://refabr1k.gitbook.io/oscp/
    //   https://0xsp.com/offensive/privilege-escalation-cheatsheet
    //   https://vulp3cula.gitbook.io/hackers-grimoire/post-exploitation/privesc-linux
    val privilegeEscalation = listOf(
        "import pty",
        "stty",
        "suid3num", // https://github.com/Anon-Exploiter/SUID3NUM
        "pspy", // https://github.com/DominicBreuker/pspy
        "TERM=xterm",
        "SHELL=bash",
        "TERM=xterm-256color",
    )

    val pentestToolNames = listOf<String>(
        "nmap",
        "masscan",
        "ssh",
//        "dnsrecon",
//        "gobuster",
    )

    // TODO add pattern
    val mining = listOf<String>(
        "CoinHive"
    )
}

import socket
import random
import time

ip = input('Enter the address to connect to:' )
#port = input('Enter the port to listen on:' )
port = 3310
socket = socket.socket()
host = socket.gethostname()
socket.connect((host, port))




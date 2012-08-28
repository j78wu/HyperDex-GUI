import BaseHTTPServer
import SimpleHTTPServer
import urllib
import random
import json
 
 
class MyHandler(SimpleHTTPServer.SimpleHTTPRequestHandler):
 
  def do_GET(self):
    form = {}
    if self.path.find('?') > -1:
      queryStr = self.path.split('?')[1]
      form = dict([queryParam.split('=') for queryParam in queryStr.split('&')])
      global value 
      #records = []
      value = {"value": {"coordinator": [{"status":"running", "startTime":"2012-08-26, 12:32", "nodeNum":"35463", "newSpaceCreation":"Successful", "newSpaceName":"phonebook", "endTime":"2012-11-04,12:22:34"}],
                         "node":[{"nodeToken":"Token_one", "nodeIP":"140.179.220.200", "incomingPort":"1234", "outgoingPort":"2345", "incomingID":"00015084", "outgoingID":"00013083", "joinTime":"1:00:23", "leavingTime":"null"},
                                 {"nodeToken":"Token_two", "nodeIP":"140.179.220.201", "incomingPort":"3526", "outgoingPort":"6354", "incomingID":"00015083", "outgoingID":"00013082", "joinTime":"1:00:23", "leavingTime":"null"},
                                 {"nodeToken":"Token_three", "nodeIP":"140.179.220.202", "incomingPort":"3522", "outgoingPort":"3214", "incomingID":"00015023", "outgoingID":"00013021", "joinTime":"1:00:21", "leavingTime":"null"},
                                 {"nodeToken":"Token_four", "nodeIP":"140.179.220.203", "incomingPort":"3521", "outgoingPort":"3212", "incomingID":"00014023", "outgoingID":"00014025", "joinTime":"1:00:23", "leavingTime":"null"}]
                        }
              }
                        
      #records.append(record1)    
      #global value
      #value = json.dumps(records)

    if 'callback' in form:
      value = ('%s(%s);' % (form['callback'], value))
 
    self.send_response(200)
    self.send_header('Content-Type', 'text/javascript')
    #self.send_header('Content-Length', len(value))
    self.send_header('Expires', '-15')
    self.send_header('Cache-Control', 'no-cache')
    self.send_header('Pragma', 'no-cache')
    self.end_headers()
 
    self.wfile.write(value)
    self.wfile.flush()
    self.connection.shutdown(1)
 
bhs = BaseHTTPServer.HTTPServer(('', 8000), MyHandler)
bhs.serve_forever()
				

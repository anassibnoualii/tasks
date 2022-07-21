counter=0
while [ $counter -lt 5 ]; do
  echo "Looping with while"
  echo "Value of counter is $counter"
  # shellcheck disable=SC2004
  counter=$(($counter + 1))
done

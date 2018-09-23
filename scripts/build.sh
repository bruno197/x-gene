#!/usr/bin/env bash

set -u

DOCKER=$(which docker)
CAT=$(which cat)

# build Docker image
"${DOCKER}" build \
            --tag \
              "xgene:1.0.0" \
            --file Dockerfile \
            .


if [ $? -eq 0 ]; then

  set -e

  "${CAT}" << EOM

  ------------------------------------------------------------------------------
  -- Docker build

  Your docker image was built.

  Image..: "${DOCKER_IMAGE_NAME}"
  Tags...: "${DOCKER_DEFAULT_TAG}"
  ------------------------------------------------------------------------------

EOM

else

  set -e

  "${CAT}" << EOM

  ------------------------------------------------------------------------------
  -- Docker build

  Error!!! While trying to build your image!!!
  ------------------------------------------------------------------------------

EOM

fi

exec "$@"
